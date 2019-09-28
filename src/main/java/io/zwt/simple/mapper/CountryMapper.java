package io.zwt.simple.mapper;

import io.zwt.simple.model.Country;

import java.util.List;

public interface CountryMapper {
    List<Country> selectAll();
}
