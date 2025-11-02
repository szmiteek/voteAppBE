package pl.vote.common.exceptions;

public class ElectorHasAlreadyVotedException extends RuntimeException {
    public ElectorHasAlreadyVotedException(String message) {
        super(message);
    }
}
