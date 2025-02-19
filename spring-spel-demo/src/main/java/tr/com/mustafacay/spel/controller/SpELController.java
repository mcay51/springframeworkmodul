package tr.com.mustafacay.spel.controller; 

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
public class SpELController {

    private final SpELEvaluator spelEvaluator;
    private final SpELMapper spelMapper;

    @PostMapping("/evaluate")
    public ResponseEntity<SpELResponseDTO> evaluateExpression(@RequestBody SpELRequestDTO request) {
        Object result = spelEvaluator.evaluate(request.getExpression());
        SpELResponseDTO response = spelMapper.toResponseDTO(request, result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/evaluate/{type}")
    public ResponseEntity<SpELResponseDTO> evaluateExpressionWithType(
            @RequestParam String expression,
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