package com.studying.gamelist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImrUrl();
    String getShortDescription();
    Integer getPosition();
}
