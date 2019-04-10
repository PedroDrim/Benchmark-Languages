import {UserInfo} from './model/UserInfo'

/**
 Classe inicial do programa
 */
export class Start {

    /**
     * Método de inicialização do projeto
     * @param args Lista de parametros obtidos via console
     */
    constructor(param: String[]) {
        let antes = new Date().getTime()

        let tamanho = this.prepareArgs(param)

        if(tamanho != -1) {

            var list: UserInfo[] = new Array()

            for(var index = 0; index < tamanho; index++){
                let user = "user" + index
                let password = "password" + index
                list.push(new UserInfo(user, password))
            }

            let time = new Date().getTime() - antes

            console.log("[OK]Tamanho: " + tamanho);
            console.log("[OK]Tempo: " + time + " ms");
        }
    }

    /**
     * Método para captura e tratamento dos parametros obtidos via console
     * @param codes Lista de parametros obtidos via console
     * @return Tamanho de usuários á serem gerados
     */
    private prepareArgs(codes: String[]): number {
        if(codes.length != 3) {
            console.log("Parametros inválidos.");
            return -1;
        }

        let line: number = Number(codes[2]);

        if(line <= 0) {
            console.log("Quantidade de linhas menor que 1.");
            return -1;
        }

        return line;
    }
}

let start: Start = new Start(process.argv);