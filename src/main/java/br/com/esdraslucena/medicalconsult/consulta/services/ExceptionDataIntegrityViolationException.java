package br.com.esdraslucena.medicalconsult.consulta.services;

public class ExceptionDataIntegrityViolationException extends RuntimeException {
    public ExceptionDataIntegrityViolationException(String message) {
        super(message);
    }
}

