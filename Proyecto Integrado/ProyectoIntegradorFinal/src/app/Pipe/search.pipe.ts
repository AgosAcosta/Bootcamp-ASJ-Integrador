import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search',
})
export class SearchPipe implements PipeTransform {
  transform(value: any[], args?: { field: string[]; searchText: string }): any {
    let list = [];
    if (!args || !args.searchText) {
      return value;
    }

    const searchValue = args.searchText.toLowerCase();

    for (let i of value) {
      for (let j of args.field) {
        if (i[j].toLowerCase().includes(searchValue)) {
          list.push(i);
          break;
        }
      }
    }
    return list;
  }
}
