package arlite.kotlinrestfulapi.validation

import org.springframework.stereotype.Component
import javax.validation.Validator;
import javax.validation.ConstrainViolationException;

@Component
class ValidationUtil(val validator:Validator) {
  fun validate(any: Any) {
     val result  = validator.validate(any)
     if(result.size != 0){
       throw ConstrainViolationException(result)
     }
  }
}