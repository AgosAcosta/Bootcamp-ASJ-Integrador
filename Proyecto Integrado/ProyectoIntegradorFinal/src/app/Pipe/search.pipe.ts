import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search',
})
export class SearchPipe implements PipeTransform {
  transform(value: any[], args?: { field: string; searchText: string }): any {
    if (!args || !args.searchText) {
      return value;
    }
    const searchValue = args.searchText.toLowerCase();
    return value.filter((item) =>
      item[args.field].toLowerCase().includes(searchValue)
    );
  }
}
