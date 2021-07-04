package sekarre.com.productservice.command.interceptors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;
import sekarre.com.productservice.command.CreateProductCommand;
import sekarre.com.productservice.core.data.ProductLookupEntity;
import sekarre.com.productservice.core.data.ProductLookupRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;

@Slf4j
@RequiredArgsConstructor
@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    private final ProductLookupRepository productLookupRepository;

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
        return (index, command) -> {

            log.info("Intercepted command: " + command.getPayloadType());

            if (CreateProductCommand.class.equals(command.getPayloadType())) {

                CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();

                ProductLookupEntity result = productLookupRepository.
                        findByProductIdOrTitle(createProductCommand.getProductId(), createProductCommand.getTitle());

                if (result != null) {
                    throw new IllegalStateException(String.format("Product with productId %s or title %s already exist",
                            createProductCommand.getProductId(), createProductCommand.getTitle()));
                }
            }

            return command;
        };
    }
}
