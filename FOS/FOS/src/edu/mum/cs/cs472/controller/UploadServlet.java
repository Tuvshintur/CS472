package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.Image;
import edu.mum.cs.cs472.service.UploadService;
import edu.mum.cs.cs472.service.impl.UploadServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/upload", description = "UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private UploadService uploadService;
   // private String UPLOAD_DIRECTORY = "/home/mb/uploads";
    private String UPLOAD_DIRECTORY = "C:\\uploads";

    public UploadServlet() {
        uploadService = new UploadServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //process only if its multipart content
        response.setContentType("text/plain");
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiParts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        File directory = new File(UPLOAD_DIRECTORY);
                        if (!directory.exists()) {
                            directory.mkdir();
                        }
                        String newName = UPLOAD_DIRECTORY + File.separator + FilenameUtils.getBaseName(name) + (System.currentTimeMillis() / 1000L) + "." + FilenameUtils.getExtension(name);
                        item.write(new File(newName));

                        Image image = uploadService.saveImage(FilenameUtils.getBaseName(name) + (System.currentTimeMillis() / 1000L) + "." + FilenameUtils.getExtension(name));

                        response.setStatus(HttpServletResponse.SC_OK);
                        response.getWriter().write(String.valueOf(image.getImageId()));
                        response.getWriter().flush();
                        response.getWriter().close();
                    }
                }

                //File uploaded successfully
                System.out.println("File Uploaded Successfully");
            } catch (Exception ex) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("File Upload Failed due to " + ex);
                response.getWriter().flush();
                response.getWriter().close();
            }

        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Sorry this Servlet only handles file upload request");
            response.getWriter().flush();
            response.getWriter().close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        if (request.getParameter("imageId") != null) {
            Image image = uploadService.getImage(Integer.parseInt(request.getParameter("imageId")));
            File f = new File(UPLOAD_DIRECTORY + File.separator + image.getPath());
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        }
    }
}
