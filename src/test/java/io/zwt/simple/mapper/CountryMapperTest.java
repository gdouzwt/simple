package io.zwt.simple.mapper;

import io.zwt.simple.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountryMapperTest extends BaseMapperTest {


    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            List<Country> countryList =
                sqlSession.selectList("io.zwt.simple.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                country.getId(), country.getCountryName(), country.getCountryCode());
        }
    }
}
