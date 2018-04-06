class InvalidParameterException(Exception):
    
    def __init__(self, msg, errors):
        super().__init__(msg)
        self.errors = errors