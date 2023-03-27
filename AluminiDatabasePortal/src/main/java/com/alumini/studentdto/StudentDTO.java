package com.alumini.studentdto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDTO {
	@NotBlank(message="Invalid name =Empty Name")
	@NotNull(message="Invalid Name=Name is Empty")
	@Size(min=3,max=30,message="Invalid Name: must be of 3-30 character")
	 private String name;
	@NotBlank(message="Invalid Graduation year=Empty Graduation year")
	@NotNull(message="Invalid Graduation year=Graduation  is Empty")
	 private String graduationYear;
	@Email(message="Invalid Email")
	 private String email;
	 @NotBlank(message="Invalid phone Number =Empty Number")
	 @NotNull(message="Invalid Phone Number=Phone Number is Empty")
	 @Pattern(regexp="^\\d(10)5",message="Invalid Phone Number........")
	  private String phone;
	 private String address;
}
