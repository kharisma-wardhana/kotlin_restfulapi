package arlite.kotlinrestfulapi.controller

import arlite.kotlinrestfulapi.model.Response
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

  @ExceptionHandler(value = [ConstraintViolationException::class])
  fun validationHandler(exception : ConstraintViolationException): Response<String> {
    return Response(
      code = 400,
      status = "failed",
      data = exception.message!!,
      message = "BadRequest"
    )
  }
}