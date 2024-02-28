import { HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor{
    
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        req = req.clone({
            withCredentials: true,
        })
        return next.handle(req)
    }

}

export const httpInterceptorPovider = [
    {provide:HTTP_INTERCEPTORS, userClass:HttpRequestInterceptor, multi:true}
]