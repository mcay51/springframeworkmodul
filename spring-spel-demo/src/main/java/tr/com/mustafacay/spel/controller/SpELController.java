package tr.com.mustafacay.spel.controller; 

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mustafacay.spel.dto.SpELRequestDTO;
import tr.com.mustafacay.spel.dto.SpELResponseDTO;
import tr.com.mustafacay.spel.mapper.SpELMapper;
import tr.com.mustafacay.spel.service.SpELEvaluator;

@RestController
@RequestMapping("/api/spel")
@RequiredArgsConstructor
@Tag(name = "SpEL Operations", description = "Spring Expression Language değerlendirme operasyonları")
public class SpELController {

    private final SpELEvaluator spelEvaluator;
    private final SpELMapper spelMapper;

    @Operation(
        summary = "SpEL ifadesini değerlendir",
        description = "Verilen SpEL ifadesini değerlendirir ve sonucunu döner"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "İfade başarıyla değerlendirildi"),
        @ApiResponse(responseCode = "400", description = "Geçersiz ifade veya değerlendirme hatası")
    })
    @PostMapping("/evaluate")
    public ResponseEntity<SpELResponseDTO> evaluateExpression(
            @Parameter(description = "SpEL ifadesi ve parametreleri")
            @RequestBody SpELRequestDTO request) {
        Object result = spelEvaluator.evaluate(request.getExpression());
        SpELResponseDTO response = spelMapper.toResponseDTO(request, result);
        return ResponseEntity.ok(response);
    }

    @Operation(
        summary = "SpEL ifadesini belirtilen tipte değerlendir",
        description = "Verilen SpEL ifadesini belirtilen tipte değerlendirir"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "İfade başarıyla değerlendirildi"),
        @ApiResponse(responseCode = "400", description = "Geçersiz ifade, tip veya değerlendirme hatası")
    })
    @GetMapping("/evaluate/{type}")
    public ResponseEntity<SpELResponseDTO> evaluateExpressionWithType(
            @Parameter(description = "Değerlendirilecek SpEL ifadesi")
            @RequestParam String expression,
            @Parameter(description = "Sonuç tipi (string, boolean, number)")
            @PathVariable String type) {
        
        Class<?> resultType = getResultType(type);
        Object result = spelEvaluator.evaluate(expression, resultType);
        
        SpELRequestDTO request = new SpELRequestDTO();
        request.setExpression(expression);
        request.setTargetType(type);
        
        SpELResponseDTO response = spelMapper.toResponseDTO(request, result);
        return ResponseEntity.ok(response);
    }
} 