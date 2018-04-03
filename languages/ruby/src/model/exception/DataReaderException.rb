export class DataReaderException extends Error {
    
    constructor(m: string) {
        super(m);
        Object.setPrototypeOf(this, DataReaderException.prototype);
    }
}