import { Cidade } from "../cidade/cidade";

export class Evento{
    id: number = 0;
    nome: string = "";
    data: string = "";
    url: string = "";
    cidade: Cidade = new Cidade();
}