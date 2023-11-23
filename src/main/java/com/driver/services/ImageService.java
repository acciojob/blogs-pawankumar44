package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        Blog b = blogRepository2.findById(blogId).orElse(null);
        image.setBlog(b);
        return imageRepository2.save(image);
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String [] screenDimension = screenDimensions.split("X");
        Image img = imageRepository2.findById(id).orElse(null);
        String [] imgDimension = img.getDimensions().split("X");
        int screenSize = Integer.parseInt(screenDimension[0]) *
                Integer.parseInt(screenDimension[1]);
        int imgSize = Integer.parseInt(imgDimension[0]) *
                Integer.parseInt(imgDimension[1]);
        return  screenSize/imgSize;
    }
}
