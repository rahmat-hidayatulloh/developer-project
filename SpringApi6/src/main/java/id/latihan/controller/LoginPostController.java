package id.latihan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import id.latihan.api.response.BaseResponse;
import id.latihan.api.response.LoginResponse;
import id.latihan.api.service.LoginService;
import id.latihan.entity.User;
import id.latihan.exception.ApplicationException;
import id.latihan.interfaces.IErrorCode;

@RestController()
public class LoginPostController {

	@Autowired(required = true)
	private LoginService loginService;

	@PostMapping(value = { "/login" })
	public LoginResponse login(@RequestBody User user) {
		LoginResponse response = new LoginResponse();
		try {
			response.setUserName(user.getUserName());
			response.setToken(loginService.login(user.getUserName(), user.getPassword()));
			response.setMessage("");
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			response.setErrorCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}

		return response;
	}

	@PostMapping(value = { "/logout" })
	public BaseResponse logout(@RequestHeader String token) {
		BaseResponse response = new BaseResponse();
		try {
			loginService.logout(token);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			response.setErrorCode(e.getErrorCode());
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			response.setErrorCode(IErrorCode.ERROR_GENERAL);
			response.setMessage("Terjadi kesalahan teknis pada server");
		}
		return response;
	}
}
