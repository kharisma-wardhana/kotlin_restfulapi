package arlite.kotlinrestfulapi.controller

import org.springframework.web.bind.anotation.RestControllerAdvice
import org.springframework.web.bind.anotation.ExceptionHandler
import javax.validation.ConstraintsViolationException

@RestControllerAdvice
class ErrorController {

  @ExceptionHandler(value = [ConstraintsViolationException::class])
  fun validationHandler(exception : ConstraintsViolationException): Response<String> {
    return Response(
      code = 400,
      status = "failed",
      data = exception.message!!,
      message = "BadRequest"
    )
  }
}