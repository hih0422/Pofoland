package com.hst.pofoland.biz.user.ctrl;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hst.pofoland.biz.user.service.impl.UserServiceImpl;
import com.hst.pofoland.biz.user.vo.UserVO;
import com.hst.pofoland.common.utils.LoggerManager;
import com.hst.pofoland.common.vo.ResponseVO;

/**
 * 
 * 시스템명 : 포트폴리오 관리 시스템
 * $com.hst.pofoland.biz.user.UserController.java
 * 클래스 설명 : User관련 Controller
 *
 * @author 김영훈
 * @since 2017. 7. 27.
 * @version 1.0.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일			수정자			수정내용
 * -------------------------------------------------
 * 2017. 7. 27.		김영훈			최초생성
 * </pre>
 */

@Controller
public class UserController {
	
	@Inject
	UserServiceImpl userServiceImpl;
	
	/**
	 * 유저 회원가입
	 * @param userVO
	 * @return
	 */
	@RequestMapping(value="user" , method=RequestMethod.POST)
	@ResponseBody
	public ResponseVO createUser(@ModelAttribute UserVO userVO) {
		
		LoggerManager.info(getClass(), userVO.toString());
		
		int code = userServiceImpl.createUser(userVO);
		
		ResponseVO responseVO = new ResponseVO();
		
		responseVO.setCode(code);
		
		return responseVO;
	}
	
	/**
	 * 유저 아이디중복확인
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="user/checkid/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO duplicateCheckId(@PathVariable String userId) {
		
		String checkId = userServiceImpl.duplicateCheckId(userId);
		
		ResponseVO responseVO = new ResponseVO();
		if (checkId != null) {
			responseVO.setCode(1);
		}
		
		return responseVO;
	}
	
	/**
	 * 유저 닉네임중복확인
	 * @param userNick
	 * @return
	 */
	@RequestMapping(value="user/checknick/{userNick}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO duplicateCheckNick(@PathVariable String userNick) {
		
		String checkNick = userServiceImpl.duplicateCheckNick(userNick);
		
		ResponseVO responseVO = new ResponseVO();
		if (checkNick != null) {
			responseVO.setCode(1);
		}
		
		return responseVO;
	}
	
	/**
	 * 유저 정보조회
	 * @param userSeq
	 * @return
	 */
	@RequestMapping(value="user/{userSeq}" , method=RequestMethod.GET)
	@ResponseBody
	public ResponseVO searchUser(@PathVariable String userSeq) {
		
		UserVO userVO = userServiceImpl.searchUser(userSeq);
		
		ResponseVO responseVO = new ResponseVO();
		responseVO.setData(userVO);

		if (userVO != null) {
			responseVO.setCode(1);
		}
		
		return responseVO;
	}
	
}
