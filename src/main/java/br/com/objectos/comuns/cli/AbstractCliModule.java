/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.comuns.cli;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class AbstractCliModule extends AbstractModule {

  @Override
  protected final void configure() {
    MapBinder<String, MainCommand> commands = MapBinder
        .newMapBinder(binder(), String.class, MainCommand.class);

    DefaultMainCommandKey defaultMainCommandKey = new DefaultMainCommandKey(getDefaultMainCommand());
    bind(DefaultMainCommandKey.class).toInstance(defaultMainCommandKey);

    bindMainCommands(commands);

    installCommands();
  }

  protected abstract String getDefaultMainCommand();

  protected abstract void bindMainCommands(MapBinder<String, MainCommand> commands);

  protected abstract void installCommands();

}