package utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Validation {

    public static void validationUserInfo(String info, HttpServletRequest request, String inputName, HttpServletResponse response) throws ServletException, IOException {
        if (info.equals("")) {
            request.setAttribute("alert", inputName);
            request.getRequestDispatcher("/valid.jsp").forward(request, response);
        }
    }
}
