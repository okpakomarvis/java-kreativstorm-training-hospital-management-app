import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimations } from '@angular/platform-browser/animations';
import { provideToastr } from 'ngx-toastr';
import { customInterceptor } from './service/custom.interceptor';
//import { HttpClientModule } from '@angular/common/http';

import { routes } from './app.routes';
import { provideHttpClient, withInterceptors } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),provideAnimations(),provideToastr({
      timeOut: 10000,
    positionClass: 'toast-bottom-right',
    preventDuplicates: true,
    }),provideHttpClient(withInterceptors([customInterceptor])) ]
};
