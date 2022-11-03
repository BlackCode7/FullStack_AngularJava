import { ISerieExercicio } from "./ISerieExercicios.model";

export class IUsuarios {
    id?:number;
    nome!: string;
    email!: string;
    seriePeito: Array<ISerieExercicio> = new Array<ISerieExercicio>();
}