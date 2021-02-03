/*
 * package com.xworkz.commonmodules.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * import com.xworkz.commonmodules.dto.EcommerceDTO; import
 * com.xworkz.commonmodules.dto.LoginDTO; import
 * com.xworkz.commonmodules.exception.ControllerException; import
 * com.xworkz.commonmodules.exception.ServiceException; import
 * com.xworkz.commonmodules.service.EcommerceService;
 * 
 * @RequestMapping("/")
 * 
 * @Component public class LoginController {
 * 
 * @Autowired private EcommerceService ecommerceService;
 * 
 * @RequestMapping(value="/login.do", method = RequestMethod.POST) public String
 * doLogin(@ModelAttribute EcommerceDTO dto,@ModelAttribute LoginDTO
 * loginDTO,Model m) throws ControllerException{ try {
 * 
 * List<EcommerceDTO> list=ecommerceService.validateAndLogin(dto);
 * System.out.println(list); for (EcommerceDTO object : list) {
 * 
 * System.out.println(object.getPassword().equals(loginDTO.getPassword()));
 * System.out.println(object);
 * if(object.getPassword().equals(loginDTO.getPassword())){
 * System.out.println("matching"); m.addAttribute("message","Login Success");
 * m.addAttribute("name","Hi "+object.getFirstName()); return "Home"; } else{
 * System.out.println(object); System.out.println("not matching");
 * m.addAttribute("message","Login not Success"); } }
 * 
 * } catch (ServiceException e) { throw new ControllerException(e.getMessage());
 * } return "Login"; }
 * 
 * 
 * }
 */