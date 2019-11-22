package edu.mum.cs.cs472.service;

import edu.mum.cs.cs472.dao.Image;

public interface UploadService {

    public Image saveImage(String path);

    public Image getImage(int imageId);
}
