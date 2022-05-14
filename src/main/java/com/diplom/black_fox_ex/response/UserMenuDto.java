package com.diplom.black_fox_ex.response;

import com.diplom.black_fox_ex.io.FileDirectories;
import com.diplom.black_fox_ex.model.User;
import lombok.Data;

@Data
public class UserMenuDto {
    private String username;
    private String imgFile;
    private String email;

    public UserMenuDto(User user) {
        this.username = user.getUsername();
        this.imgFile = FileDirectories.USER_IMG.getPath() + user.getImgFile();
        this.email = user.getEmail();
    }
}
