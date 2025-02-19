package tr.com.mustafacay.spel.mapper;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import tr.com.mustafacay.spel.dto.SpELRequestDTO;
import tr.com.mustafacay.spel.dto.SpELResponseDTO;

import static org.junit.jupiter.api.Assertions.*;

class SpELMapperTest {

    private final SpELMapper mapper = Mappers.getMapper(SpELMapper.class);

    @Test
    void testToResponseDTO() {
        SpELRequestDTO request = new SpELRequestDTO();
        request.setExpression("2 + 2");

        SpELResponseDTO response = mapper.toResponseDTO(request);

        assertNotNull(response);
        assertEquals(request.getExpression(), response.getExpression());
        assertTrue(response.isSuccessful());
    }

    @Test
    void testToResponseDTOWithResult() {
        SpELRequestDTO request = new SpELRequestDTO();
        request.setExpression("2 + 2");
        Integer result = 4;

        SpELResponseDTO response = mapper.toResponseDTO(request, result);

        assertNotNull(response);
        assertEquals(request.getExpression(), response.getExpression());
        assertEquals(result, response.getResult());
        assertEquals("Integer", response.getResultType());
        assertTrue(response.isSuccessful());
    }
} 