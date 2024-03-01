import { HttpInterceptorFn } from '@angular/common/http';

export const customInterceptor: HttpInterceptorFn = (req, next) => {
  const token = localStorage.getItem('loginToken');
   const newcloneRequest = req.clone({
    setHeaders:{
      Authorization:`Bearer ${token}`
    }
   });
  return next(newcloneRequest);
};
