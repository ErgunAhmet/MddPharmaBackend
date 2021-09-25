export class Medication {
  constructor(name: string, type: string, status: string) {
    this.name = name;
    this.type = type;
    this.status = status;
  }

  id: number;
  name: string;
  type: string;
  status: string;

}
