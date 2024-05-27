package com.okta.system.System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateResourceDto {
    private String url;
    private String room;
}
