package tr.com.mustafacay.transaction.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.mustafacay.transaction.dto.TransferRequest;
import tr.com.mustafacay.transaction.entity.Account;
import tr.com.mustafacay.transaction.service.BankService;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Banka işlemleri için REST controller
 */
@RestController
@RequestMapping("/api/bank")
@Tag(name = "Bank Operations", description = "Banka işlemleri için API endpoint'leri")
public class BankController {
    
    private final BankService bankService;
    
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }
    
    @Operation(summary = "Yüksek izolasyonlu para transferi")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Transfer başarılı"),
        @ApiResponse(responseCode = "400", description = "Yetersiz bakiye"),
        @ApiResponse(responseCode = "404", description = "Hesap bulunamadı")
    })
    @PostMapping("/transfer/high-isolation")
    public ResponseEntity<Void> transferWithHighIsolation(
            @Valid @RequestBody TransferRequest request) {
        bankService.transferWithHighIsolation(
            request.getFromAccount(),
            request.getToAccount(),
            request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Yeni transaction ile para transferi")
    @PostMapping("/transfer/new-transaction")
    public ResponseEntity<Void> transferWithNewTransaction(
            @Valid @RequestBody TransferRequest request) {
        bankService.transferWithNewTransaction(
            request.getFromAccount(),
            request.getToAccount(),
            request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Loglama ile para transferi")
    @PostMapping("/transfer/with-logging")
    public ResponseEntity<Void> transferWithLogging(
            @RequestBody TransferRequest request) {
        bankService.transferWithLogging(
            request.getFromAccount(),
            request.getToAccount(),
            request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Programmatic transaction ile para transferi")
    @PostMapping("/transfer/programmatic")
    public ResponseEntity<Void> transferWithProgrammaticTransaction(
            @RequestBody TransferRequest request) {
        bankService.transferWithProgrammaticTransaction(
            request.getFromAccount(),
            request.getToAccount(),
            request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
    
    @Operation(summary = "Tüm hesapları listele (Read-only)")
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(bankService.getAllAccountsReadOnly());
    }
} 