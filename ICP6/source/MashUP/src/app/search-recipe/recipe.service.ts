import { Injectable } from '@angular/core';
import { environment} from './../../environments/environment';
import { HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  public apiKeys = {
    restAppId: environment.FS_CLIENT_ID,
    restAppKey: environment.FS_CLIENT_SECRET,
    foodAppId: environment.EDAMAM_APPLICATION_ID,
    foodAppKey: environment.EDAMAM_APPLICATION_KEY
  }
  constructor(private http:HttpClient) { }

  getRecipeInformation(recipeName: string) {
    return this.http.get("https://api.edamam.com/search?app_id="+this.apiKeys.foodAppId + "&app_key=" + this.apiKeys.foodAppKey + "&q=" + recipeName);
  }

  getRestaurantInfo(recipeName:string, cityName:string) {
    return this.http.get("https://api.foursquare.com/v2/venues/explore?v=20180323&client_id="+ this.apiKeys.restAppId + "&client_secret=" + this.apiKeys.restAppKey + "&near=" + cityName + "&query=" + recipeName);
  }
}
