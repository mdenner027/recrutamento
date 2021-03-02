import { Responsavel } from "../responsaveis/responsavel.model";

export interface Tarefa {
    idTarefa?: number;
    tituloTarefa: string;
    descricaoTarefa: string;
    prioridadeTarefa: number;
    statusTarefa?: number;
    deadlineTarefa: string;
    responsavelTarefa: Responsavel;
}