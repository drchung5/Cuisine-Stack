package com.dchung.cuisine.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Cuisine {

  protected Cuisine(){}

  public Cuisine(@NotNull Long cuisine_id, @NotNull String name) {
    this.cuisine_id = cuisine_id;
    this.name = name;
  }

  @Id
  private Long cuisine_id;

  @NotNull
  private String name;

}

