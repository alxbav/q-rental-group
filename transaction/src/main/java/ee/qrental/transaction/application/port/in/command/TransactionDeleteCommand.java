package ee.qrental.transaction.application.port.in.command;

import ee.qrental.common.core.api.AbstractDeleteCommand;


public class TransactionDeleteCommand extends AbstractDeleteCommand<TransactionDeleteCommand> {
    public TransactionDeleteCommand(Long id) {
        super(id);
    }
}