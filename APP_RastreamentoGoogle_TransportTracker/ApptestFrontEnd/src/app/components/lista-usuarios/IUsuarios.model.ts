import { ISerieExercicio } from "./ISerieExercicios.model";

export class IUsuarios {
    id?:number;
    nome!: string;
    email!: string;
    seriePeito: Array<any> = new Array<ISerieExercicio>();
}