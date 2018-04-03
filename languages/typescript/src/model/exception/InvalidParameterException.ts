export class InvalidParameterException extends Error {
    
    constructor(m: string) {
        super(m);
        Object.setPrototypeOf(this, InvalidParameterException.prototype);
    }
}