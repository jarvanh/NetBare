/*  NetBare - An android network capture and injection library.
 *  Copyright (C) 2018-2019 Megatron King
 *  Copyright (C) 2018-2019 GuoShi
 *
 *  NetBare is free software: you can redistribute it and/or modify it under the terms
 *  of the GNU General Public License as published by the Free Software Found-
 *  ation, either version 3 of the License, or (at your option) any later version.
 *
 *  NetBare is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE. See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with NetBare.
 *  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.megatronking.netbare.http;

import com.github.megatronking.netbare.gateway.SSLRefluxInterceptor;
import com.github.megatronking.netbare.ssl.SSLRefluxCallback;

/**
 * An interceptor locates at the last layer of the interceptors. It is responsible for send
 * plaintext packets to {@link HttpSSLCodecInterceptor}.
 *
 * @author Megatron King
 * @since 2018-11-15 15:39
 */
/* package */ class HttpSSLRefluxInterceptor extends
        SSLRefluxInterceptor<HttpRequest, HttpRequestChain, HttpResponse, HttpResponseChain>
        implements HttpInterceptor {

    /* package */ HttpSSLRefluxInterceptor(SSLRefluxCallback<HttpRequest, HttpResponse> refluxCallback) {
        super(refluxCallback);
    }

    @Override
    protected boolean shouldReflux(HttpRequestChain chain) {
        return chain.request().isHttps();
    }

    @Override
    protected boolean shouldReflux(HttpResponseChain chain) {
        return chain.response().isHttps();
    }

}
