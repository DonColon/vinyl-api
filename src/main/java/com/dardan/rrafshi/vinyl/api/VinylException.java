package com.dardan.rrafshi.vinyl.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dardan.rrafshi.commons.exceptions.ApplicationRuntimeException;


public final class VinylException
{
	private VinylException() {}


	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public static class BadRequest extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public BadRequest(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public BadRequest(final String message)
		{
			super(message);
		}
	}

	@ResponseStatus(code=HttpStatus.UNAUTHORIZED)
	public static class Unauthorized extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public Unauthorized(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public Unauthorized(final String message)
		{
			super(message);
		}
	}

	@ResponseStatus(code=HttpStatus.FORBIDDEN)
	public static class Forbidden extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public Forbidden(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public Forbidden(final String message)
		{
			super(message);
		}
	}

	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public static class NotFound extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public NotFound(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public NotFound(final String message)
		{
			super(message);
		}
	}

	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	public static class InternalServerError extends ApplicationRuntimeException
	{
		private static final long serialVersionUID = 1L;


		public InternalServerError(final String message, final Throwable cause)
		{
			super(message, cause);
		}

		public InternalServerError(final String message)
		{
			super(message);
		}
	}
}
