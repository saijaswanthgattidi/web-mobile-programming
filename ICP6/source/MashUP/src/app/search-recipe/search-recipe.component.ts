import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from './../../environments/environment';
import {RecipeService} from "./recipe.service";

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  @ViewChild('recipe') recipes: ElementRef;
  @ViewChild('place') places: ElementRef;
  recipeVal: any;
  placeVal: any;
  venueList = [];
  recipeList = [];

  currentLat: any;
  currentLong: any;
  geolocationPosition: any;


  constructor(private rService: RecipeService) {
  }

  ngOnInit() {

    window.navigator.geolocation.getCurrentPosition(
      position => {
        this.geolocationPosition = position;
        this.currentLat = position.coords.latitude;
        this.currentLong = position.coords.longitude;
      });
  }

  getVenues() {
    this.venueList = [];
    this.recipeList = [];
    this.recipeValue = this.recipes.nativeElement.value;
    this.placeValue = this.places.nativeElement.value;

    if (this.recipeValue !== null) {
        this.rService.getRecipeInformation(this.recipeValue).subscribe(results => {
          const recipeResults = results["hits"];
          recipeResults.map(e => {
            const recipe = e['recipe'];
            this.recipeList.push({
              name: recipe['label'],
              url: recipe['url'],
              icon: recipe['image']
            })
          })
        })
    }

    if (this.placeValue != null && this.placeValue !== '' && this.recipeValue != null && this.recipeValue !== '') {
        this.rService.getRestaurantInfo(this.recipeValue, this.placeValue).subscribe(results=> {
          const response = results["response"];
          const places = response["groups"][0]["items"].slice(0, 5);
          places.map((place) => {
            const placeObj = {
              id: place["venue"]["id"],
              name: place["venue"]["name"],
              location: {
                formattedAddress: [place["venue"]["location"]["address"], place["venue"]["location"]["city"], place["venue"]["location"]["country"]]
              }
            };
            this.venueList.push(placeObj);
          });
        })
    }
  }
}
