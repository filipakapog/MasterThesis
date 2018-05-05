package cemadoare.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

/**
 *
 * @author Filip
 */
public interface Constants {
    enum PATHS {
        IMGS_HOME("/imgs/"),
        GITHUB_LOGO(IMGS_HOME.getPath() + "GitHub-Mark-32px.png"),
        DOCTOR_LOGO(IMGS_HOME.getPath() + "login_doctor.jpg"),
        MATLAB_DATA(MyPropertyManager.getProperty("matlab.dataPath"));
        
        private String path;
        
        PATHS(String path) {
            this.path = path;
        }
        
        public String getPath() { return this.path; };
    }
    enum COLORS {
        FOCUSED(new Color(187,22,237)),
        UNFOCUSED(new Color(60,63,65));

        private Color color;

        COLORS(Color color) { this.color = color; }

        public Color getColor() { return this.color; }

    }
}
