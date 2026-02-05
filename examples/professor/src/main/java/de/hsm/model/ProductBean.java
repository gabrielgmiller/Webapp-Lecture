package de.hsm.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBean implements Serializable {
    private String search;
    private String searchIn;
}
