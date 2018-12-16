package com.algaworks.algamoney.dois.api.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algamoney.dois.api.model.Pessoa;
import com.algaworks.algamoney.dois.api.service.exception.AlgamoneyNegocioException;

@ControllerAdvice
public class AlgamoneyExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagem = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String descricao = ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, descricao));
		return handleExceptionInternal(ex, erros, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, status, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception,
			WebRequest request) {
		String mensagem = messageSource.getMessage("mensagem.recurso.nao-encontrado", null,
				LocaleContextHolder.getLocale());
		String descricao = exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, descricao));
		return handleExceptionInternal(exception, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({JpaObjectRetrievalFailureException.class})
	public ResponseEntity<Object> handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException exception,
			WebRequest request) {
		
		String mensagem = messageSource.getMessage("mensagem.recurso.operacao-nao-permitida", null,
				LocaleContextHolder.getLocale());
		Throwable cause = ExceptionUtils.getRootCause(exception);
		String descricao = cause.getMessage();
		List<Erro> erros = Arrays.asList(new Erro(mensagem, descricao));
		return handleExceptionInternal(exception, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	

	@ExceptionHandler({AlgamoneyNegocioException.class})
	public ResponseEntity<Object> handleAlgamoneyNegocioException(AlgamoneyNegocioException exception,
			WebRequest request) {
		
		String mensagem = messageSource.getMessage(exception.getMessage(), null,
				LocaleContextHolder.getLocale());
		Throwable cause = ExceptionUtils.getRootCause(exception);
		String descricao = Optional.ofNullable(cause).map(causeNaoNula -> causeNaoNula.getMessage()).orElse(mensagem);
		List<Erro> erros = Arrays.asList(new Erro(mensagem, descricao));
		return handleExceptionInternal(exception, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}

	private List<Erro> criarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String mensagemUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String mensagemDesenvolvedor = fieldError.toString();
			erros.add(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		}
			
		return erros;
	}

	public class Erro {

		private String mensagem;
		private String descricao;

		public Erro(String mensagem, String descricao) {
			this.mensagem = mensagem;
			this.descricao = descricao;
		}

		public String getMensagem() {
			return mensagem;
		}

		public String getDescricao() {
			return descricao;
		}

	}
}
