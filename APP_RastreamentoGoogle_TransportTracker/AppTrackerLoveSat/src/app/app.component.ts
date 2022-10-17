import { Component } from '@angular/core';
import { window } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AppTrackerLoveSat';

  map: google.maps.Map;

  constructor() { }
  ngOnInit(): void {
  }


initMap(): void {
  this.map = new google.maps.Map(document.getElementById("map") as HTMLElement, {
    center: { lat: -34.397, lng: 150.644 },
    zoom: 8,
  });
}

declare global {
  interface Window {   initMap: () => void;
  }
}

window.initMap = initMap;
 


}
