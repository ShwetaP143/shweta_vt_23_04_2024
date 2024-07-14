package com.assignment.Interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.assignment.annotation.Permission;
import com.assignment.enums.LogicEnum;
import com.assignment.enums.PermissionsEnum;
import com.assignment.utils.JwtTokenUtil;
import java.util.Arrays;



@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
	
	  @Autowired
	    private JwtTokenUtil jwtTokenUtil;

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        String authorizationHeader = request.getHeader("Authorization");

	        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
	            String token = authorizationHeader.substring(7);
	            String username = jwtTokenUtil.getUsernameFromToken(token);
	            String roles = jwtTokenUtil.getRolesFromToken(token);

	            if (username != null && jwtTokenUtil.validateToken(token, username)) {
	                // Perform authorization check based on roles
	            	 if (handler instanceof HandlerMethod) {
	                     HandlerMethod handlerMethod = (HandlerMethod) handler;
	                     Method method = handlerMethod.getMethod();
	                     
	                     if (method.isAnnotationPresent(Permission.class)) {
	                         Permission permission = method.getAnnotation(Permission.class);
	                         List<PermissionsEnum> requiredPermissions = Arrays.asList(permission.permissions());
	                         LogicEnum logicType = permission.type();

	                         if (checkPermissions(roles, requiredPermissions, logicType)) {
	                             return true;
	                         } else {
	                             response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	                             return false;
	                         }
	                     }
	                 }
	                return true;
	            }
	        }

	        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        return false;
	    }
	    
	    private boolean checkPermissions(String roles, List<PermissionsEnum> requiredPermissions, LogicEnum logicType) {
	        List<String> userRoles = Arrays.asList(roles.split(","));
	        if (logicType == LogicEnum.All) {
	            return userRoles.containsAll(requiredPermissions);
	        } else {
	            for (PermissionsEnum permission : requiredPermissions) {
	                if (userRoles.contains(permission)) {
	                    return true;
	                }
	            }
	            return false;
	        }
	    }
	
}
