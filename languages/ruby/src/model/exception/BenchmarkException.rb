export class BenchmarkException extends Error {
    
    constructor(m: string) {
        super(m);
        Object.setPrototypeOf(this, BenchmarkException.prototype);
    }
}