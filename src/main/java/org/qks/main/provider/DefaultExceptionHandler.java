package org.qks.main.provider;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        Map<String, Object> json = new HashMap<>();
        json.put("code", 500);
        json.put("msg", "服务器异常");
        log.error("服务器异常: ", e);
        return Response.serverError().entity(json).build();
    }
}
