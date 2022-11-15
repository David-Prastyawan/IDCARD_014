/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idcard.project3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author David
 */
@Controller
public class myController {
    
    @RequestMapping("/sendData")
    @ResponseBody
    public String getData(@RequestParam("mytext") String getText,
                          @RequestParam("myImage") MultipartFile image,
                          @RequestParam("myDate")
                          @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws IOException{
        
        String blob = Base64.encodeBase64String(image.getBytes());
        
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEEEEE dd MMMM yyyy");
        
        String newTanggal = tanggal.format(date);
        
        
        return "Nama: " + getText +"<br><br>"+ 
               "Tanggal: "+newTanggal +"<br><br>" + 
               "Foto:" + "<br> <img width='250' src= 'data:image/jpeg;base64,"+blob+"' /><br>";
    }
    
}